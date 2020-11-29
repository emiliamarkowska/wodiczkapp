import React from 'react';
import Background from './Background';

export default class BaseDesktop extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
      return <Background/>;
    }
}