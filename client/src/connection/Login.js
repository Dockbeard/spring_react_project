import './connection.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';
import { Link } from 'react-router-dom';



function Login() {
    return (
        <div className="login">
            <div>
                <div className="sidenav">
                    <div className="login-main-text">

                        <Link to=''><h2 className='homeLogo'>DASHBOARD</h2></Link><h2>Connexion</h2>
                        <p>Utilisez vos identifiant de connexion.</p>
                    </div>
                </div>
                <div className="main">
                    <div className="col-md-6 col-sm-12">
                        <div className="login-form">
                            <form>
                                <div className="form-group">
                                    <label>Email</label>
                                    <input type="email" className="form-control" placeholder="exemple@gmail.com" />
                                </div>
                                <div className="form-group">
                                    <label>Mot de passe</label>
                                    <input type="password" className="form-control" placeholder="......" />
                                </div>

                                <button type="submit" className="btn btn-black">Se connecter</button>

                                <Link to='register'>
                                <p className='otherOption'>S'inscrire</p>
                                </Link>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Login;
