import './dashboard.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';
import Sidebar from "./Navigation/Sidebar";
import Display from "./Navigation/Display";
import {Col, Row} from "react-bootstrap";

class Dashboard extends React.Component {

    constructor(props) {
        super(props);
        this.state = {};
    }

    componentDidMount() {
        var myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");

        var requestOptions = {
            method: 'GET',
            headers: myHeaders,
            redirect: 'manual'
        };

        fetch("http://localhost:8080/api/getServicesAndWidgets", requestOptions)
            .then(response => response.json())
            .then(result => {
                this.setState({
                    items: result,
                    isLoaded: true
                });
            })
            .catch(error => {
                this.setState({
                    isLoaded: true,
                    error
                });
            });
    }


    render()
    {
        const { error, isLoaded, items } = this.state;
        let nbWidgets = 0;
        if (error) {
            return <div>Erreur : {error.message}</div>;
        } else if (!isLoaded) {
            return <div>Chargement…</div>;
        } else {
            items.map((sidebarItem, index) => {
                sidebarItem.items.map((widget) => (
                    nbWidgets++
                ));
            });
            return (
                <Row>
                    <Col className="sidebar" xs="3" md="3" lg="3">
                        <Sidebar items={items}/>
                    </Col>
                    <Col>
                        <Display nbWidgets={nbWidgets} />
                    </Col>
                </Row>
            );
        }
    }

}
export default Dashboard;
