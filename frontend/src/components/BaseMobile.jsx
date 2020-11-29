import React from 'react';
import Background from './Background';

export default class BaseMobile extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
      return <Background/>;
    }
}