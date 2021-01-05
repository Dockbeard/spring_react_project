import React from 'react';
import { Container, Row, Col } from 'react-bootstrap';

class TwitchTopGames extends React.Component {
    constructor(props) {
        super(props);
    }

    componentDidMount() {

    }

    render() {
        return (
            <div>
                <h1>Twitch</h1>
                <p>Top twitch games</p>
            </div>
        );
    }
}

export default  TwitchTopGames;
