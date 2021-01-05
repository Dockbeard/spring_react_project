import React from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import TwitchTopGames from "../Widgets/TwitchTopGames";
import TwitchGameAnalytics from "../Widgets/TwitchGameAnalytics";
import TwitchTopStreamers from "../Widgets/TwitchTopStreamers";

class Display extends React.Component {

    constructor(props) {
        super(props);
        console.log(props);
        this.state = {};
    }

    render() {
        let rows = [];
        let widgets = [
            TwitchTopGames,
            TwitchGameAnalytics,
            TwitchTopStreamers
        ];
        for (let i = 0; i < this.props.nbWidgets; i++) {
            const Widgets = widgets[i];
            rows.push(<Col key={i} xs lg="4"> <Widgets/> </Col>);
        }
        return (
            <Container>
                <Row>
                    {rows}
                </Row>
            </Container>
        );
    }

}

export default Display;
