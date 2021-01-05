import './connection.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';
<<<<<<< HEAD
import Login from "./Login";
=======
>>>>>>> 7a7dcce8c5adb8b7f5e972526df3e3da1832d8fc
import {Link} from "react-router-dom";

function Register() {
    return (
        <div className="login">
            <div>
                <div className="sidenav">
                    <div className="login-main-text">
                        <Link to=''><h2 className='homeLogo'>DASHBOARD</h2></Link><h2>Inscription</h2>
                        <p>Renseignez vos informations personnelles.</p>
                    </div>
                </div>
                <div className="main">
                    <div className="col-md-6 col-sm-12">
                        <div className="login-form">
                            <form>
                                <div className="form-group">
                                    <label>Nom et Prenom</label>
                                    <input type="text" className="form-control" placeholder="Deniro Robert" />
                                </div>
                                <div className="form-group">
                                    <label>Email</label>
                                    <input type="email" className="form-control" placeholder="exemple@gmail.com" />
                                </div>
                                <div className="form-group">
                                    <label>Mot de passe</label>
                                    <input type="password" className="form-control" placeholder="....." />
                                </div>

                                <button type="submit" className="btn btn-secondary">S'inscrire</button>

                                <Link to='login'>
                                   <p className='otherOption'>Se connecter</p>
                                </Link>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Register;
