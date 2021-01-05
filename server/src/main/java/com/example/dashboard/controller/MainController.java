package com.example.dashboard.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dashboard.model.Users;
import com.example.dashboard.repository.UtilisateursRepository;
import com.example.dashboard.model.Services;
import com.example.dashboard.repository.ServicesRepository;
import com.example.dashboard.model.Widgets;
import com.example.dashboard.repository.WidgetsRepository;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.example.dashboard.model.UserServices;
import com.example.dashboard.repository.UserServicesRepository;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    UtilisateursRepository utilisateursRepository;

    @GetMapping("/users/get")
    public ResponseEntity<Object> getUser(@RequestParam(required = false) Integer id,
            @RequestParam(required = false) String mail) {
        if (id != null) {
            try {
                return new ResponseEntity<>(utilisateursRepository.findById(id), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else if (mail != null) {
            try {
                return new ResponseEntity<>(utilisateursRepository.findByMail(mail), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            try {
                List<Users> utilisateurs = new ArrayList<>();
                utilisateursRepository.findAll().forEach(utilisateurs::add);
                if (utilisateurs.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }

                return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/users/delete")
    public ResponseEntity deleteUserById(@RequestParam(required = false) Integer id,
            @RequestParam(required = false) String mail) {
        if (id != null) {
            try {
                utilisateursRepository.deleteById(id);
                return new ResponseEntity<>("L'utilisateur ayant l'id: " + id + " a été supprimé.", HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } else if (mail != null) {
            try {
                utilisateursRepository.deleteByMail(mail);
                return new ResponseEntity<>("L'utilisateur ayant le mail: " + mail + " a été supprimé.", HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Veuillez fournir soit un email soit un id.", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users/create")
    public Object createUser(@RequestBody Users user) {
        try {
            Users _user = utilisateursRepository.save(new Users(user.getMail(), user.getPassword(), user.getName()));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            ConstraintViolationException exception = (ConstraintViolationException) e.getCause();
            if (exception.getErrorCode() == 1062) {
                return new ResponseEntity<>("Le mail utilisé existe déjà", HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @PutMapping("/users/update")
    public ResponseEntity<Object> updateUser(@RequestBody Users user) {
        try {
            Optional<Users> userData = utilisateursRepository.findOById(user.getId());
            if (userData.isPresent()) {
                Users _user = userData.get();
                if (user.getMail() != null) {
                    _user.setMail(user.getMail());
                } else if (user.getName() != null) {
                    _user.setName(user.getName());
                } else if (user.getPassword() != null) {
                    _user.setPassword(user.getPassword());
                }
                return new ResponseEntity<>(utilisateursRepository.save(_user), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            ConstraintViolationException exception = (ConstraintViolationException) e.getCause();
            if (exception.getErrorCode() == 1062) {
                return new ResponseEntity<>("Le mail utilisé existe déjà", HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @Autowired
    ServicesRepository servicesRepository;

    @GetMapping("/services/get")
    public ResponseEntity<Object> getServices(@RequestParam(required = false) Integer id,
            @RequestParam(required = false) String name) {
        if (id != null) {
            try {
                return new ResponseEntity<>(servicesRepository.findById(id), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else if (name != null) {
            try {
                return new ResponseEntity<>(servicesRepository.findByName(name), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            try {
                List<Services> services = new ArrayList<>();
                servicesRepository.findAll().forEach(services::add);
                if (services.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }

                return new ResponseEntity<>(services, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @Autowired
    WidgetsRepository widgetsRepository;

    @GetMapping("/widgets/get")
    public ResponseEntity<Object> getWidgets(@RequestParam(required = false) Integer id,
            @RequestParam(required = false) String name) {
        if (id != null) {
            try {
                return new ResponseEntity<>(widgetsRepository.findById(id), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else if (name != null) {
            try {
                return new ResponseEntity<>(widgetsRepository.findByName(name), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            try {
                List<Widgets> widgets = new ArrayList<>();
                widgetsRepository.findAll().forEach(widgets::add);
                if (widgets.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }

                return new ResponseEntity<>(widgets, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @Autowired
    UserServicesRepository userServiceRepository;

    @GetMapping("/users/services/get")
    public ResponseEntity<Object> getUserServices(@RequestParam(required = false) Integer id,
            @RequestParam(required = false) Integer user) {
        if (id != null) {
            try {
                return new ResponseEntity<>(userServiceRepository.findById(id), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else if (user != null) {
            try {
                return new ResponseEntity<>(userServiceRepository.findByUser(user), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            try {
                List<UserServices> userServices = new ArrayList<>();
                userServiceRepository.findAll().forEach(userServices::add);
                if (userServices.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }

                return new ResponseEntity<>(userServices, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/users/services/delete")
    public ResponseEntity deleteUserServicesById(@RequestParam(required = false) Integer id,
            @RequestParam(required = false) Integer user, @RequestParam(required = false) Integer service) {
        if (id != null) {
            try {
                userServiceRepository.deleteById(id);
                return new ResponseEntity<>("Le service ayant l'id: " + id + " a été supprimé.", HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } else if (user != null && service != null) {
            try {
                userServiceRepository.deleteByUserAndService(user, service);
                return new ResponseEntity<>("Le service" + service + " de l'utilisateur: " + user + " a été supprimé.",
                        HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Veuillez fournir soit un id soit un couple <utilisateur,service>.",
                    HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users/services/create")
    public Object createUserServices(@RequestBody UserServices userServices) {
        try {
            UserServices _userService = userServiceRepository
                    .save(new UserServices(userServices.getUser(), userServices.getOrder(), userServices.getOrder()));
            return new ResponseEntity<>(_userService, HttpStatus.CREATED);
        } catch (Exception e) {
            ConstraintViolationException exception = (ConstraintViolationException) e.getCause();
            if (exception.getErrorCode() == 1062) {
                return new ResponseEntity<>("Ce service existe déjà", HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @PutMapping("/users/services/update")
    public ResponseEntity<Object> updateUserServices(@RequestBody UserServices userServices) {
        try {
            Optional<UserServices> userData = userServiceRepository.findOByIdAndUser(userServices.getUser(),
                    userServices.getService());
            if (userData.isPresent()) {
                UserServices _userServices = userData.get();
                if ((Integer) userServices.getOrder() != null) {
                    _userServices.setOrder(userServices.getOrder());
                } else if ((Integer) userServices.getService() != null) {
                    _userServices.setService(userServices.getService());
                } else if ((Integer) userServices.getUser() != null) {
                    _userServices.setUser(userServices.getUser());
                }
                return new ResponseEntity<>(userServiceRepository.save(_userServices), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            ConstraintViolationException exception = (ConstraintViolationException) e.getCause();
            if (exception.getErrorCode() == 1062) {
                return new ResponseEntity<>("Ce service utilisé existe déjà", HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @GetMapping("/getServicesAndWidgets")
    public ResponseEntity<Object> getServicesAndWidgets() {
        try {
            List<Object> res = new ArrayList<>();
            servicesRepository.findAll().forEach(service -> {
                JsonObject item = new JsonObject();
                List<Widgets> temp2 = new ArrayList<>();
                Integer serviceTemp = service.getId();
                widgetsRepository.findByService(serviceTemp).forEach(temp2::add);
                item.put("items", temp2);
                item.put("name", service.getName());
                item.put("id", service.getId());
                res.add(item);
            });
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}