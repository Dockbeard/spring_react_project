import './home.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';
import { Link } from 'react-router-dom';



function Home() {
    return (
        <div>

            <nav className="navbar navbar-expand-lg navbar-dark bg-dark fixed-bottom">
                <div className="container">
                    <Link to='dashboard'>
<<<<<<< HEAD
                    <a className="navbar-brand" >Découvrir Dashboard</a>
=======
                    <p className="navbar-brand">Découvrir Dashboard</p>
>>>>>>> 7a7dcce8c5adb8b7f5e972526df3e3da1832d8fc
                    </Link>
                    <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon" />
                    </button>
                    <div className="collapse navbar-collapse" id="navbarResponsive">
                        <ul className="navbar-nav ml-auto">
                            <li className="nav-item active">
                                <Link to='login'>
<<<<<<< HEAD
                                <a className="nav-link">Se connecter
                                </a>
=======
                                <p className="nav-link">Se connecter
                                </p>
>>>>>>> 7a7dcce8c5adb8b7f5e972526df3e3da1832d8fc
                                </Link>
                            </li>
                            <li className="nav-item">
                                <Link to='login'>
<<<<<<< HEAD
                                <a className="nav-link" >S'inscrire</a>
=======
                                <p className="nav-link">S'inscrire</p>
>>>>>>> 7a7dcce8c5adb8b7f5e972526df3e3da1832d8fc
                                </Link>
                            </li>


                        </ul>
                    </div>
                </div>
            </nav>

            <section>
                <div className="container">
                    <div className="row">
                        <div className="col-lg-6">
                            <h1 className="mt-5 ">Dashboard</h1>
                            <p>Prenez le contrôle de votre vie numérique
                                Personnalisez votre Dashboard pour suivre vos centres d'intérêts. Consultez vos réseaux sociaux, recevez des alertes d'actualité ou lisez des articles sur les sujets qui vous importent. Affichez votre calendrier, votre liste de tâches, vos emails et vos applications en un seul endroit.</p>
                        </div>
                    </div>
                </div>
            </section>

        </div>
    );
}

export default Home;
