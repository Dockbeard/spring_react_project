import React from "react";
<<<<<<< HEAD
import Sidebar from "./dashboard/Navigation/Sidebar";
=======
>>>>>>> 7a7dcce8c5adb8b7f5e972526df3e3da1832d8fc
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import login from "./connection/Login";
import register from "./connection/Register";
import home from "./home/Home";
import dashboard from "./dashboard/Dashboard"
<<<<<<< HEAD
import VideoLabelIcon from '@material-ui/icons/VideoLabel';
import SportsSoccerIcon from '@material-ui/icons/SportsSoccer';
import MusicNoteIcon from '@material-ui/icons/MusicNote';
import MailIcon from '@material-ui/icons/Mail';
import { BrowserRouter as Router, Switch, Route} from 'react-router-dom';

function onClick(e, item) {
  window.alert(JSON.stringify(item, null, 2));
}

const items = [
  {
    name: "Twitch",
    label: "Twitch",
    Icon: VideoLabelIcon,
    items: [
      { name: "Top games", label: "Top games", onClick },
      { name: "Top streamers", label: "Top streamers", onClick },
      { name: "Analyse sur un jeu", label: "Analyse sur un jeu", onClick }
    ]
  },
  "divider",
  {
    name: "Football",
    label: "Football",
    Icon: SportsSoccerIcon,
    items: [
      { name: "Classement Ligue 1", label: "Classement Ligue 1", onClick },
      { name: "Classement Premier league", label: "Classement Premier league", onClick }
    ]
  },
  "divider",
  {
    name: "Spotify",
    label: "Spotify",
    Icon: MusicNoteIcon,
    items: [
      { name: "Top musiques", label: "Top musiques", onClick },
      { name: "Top musiques d'un artiste", label: "Top musiques d'un artiste", onClick }
    ]
  },
  "divider",
  {
    name: "Gmail",
    label: "Gmail",
    Icon: MailIcon,
    items: [
      { name: "Voir les 5 derniers mails", label: "Voir les 5 derniers mails", onClick },
      { name: "Envoyer un mail", label: "Envoyer un mail", onClick }
    ]
  }
];

function App() {
  return (
      <Router>
        <div className="App">
          <Switch>
            <Route path="/" exact component={home}/>
            <Route path="/login" component={login}/>
            <Route path="/register" component={register}/>
            <Route path="/dashboard" component={dashboard}/>
          </Switch>
        </div>
      </Router>



=======
import { BrowserRouter as Router, Switch, Route} from 'react-router-dom';

function App() {
  return(
      <Router>
        <div className="App">
            <Switch>
          <Route path="/" exact component={home}/>
          <Route path="/login" component={login}/>
          <Route path="/register" component={register}/>
          <Route path="/dashboard" component={dashboard}/>
            </Switch>
        </div>
      </Router>
>>>>>>> 7a7dcce8c5adb8b7f5e972526df3e3da1832d8fc
  );
}

export default App;
