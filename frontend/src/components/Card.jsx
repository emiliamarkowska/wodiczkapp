import React from 'react';
import './Card.css';

export default class Card extends React.Component {
    constructor(props) {
        super(props);

        this.onCardClicked = this.onCardClicked.bind(this);
    }

    onCardClicked = (e) => {
        console.log(e);
        e.target.scrollIntoView();
        //this.scrollTo(0, 300);
    }

    render() {
      return (
        <div className="card">{this.props.children}</div>
      );
    }
}