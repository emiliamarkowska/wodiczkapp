import React from 'react';
import BaseDesktop from './BaseDesktop';
import BaseMobile from './BaseMobile';

export default class DeviceReckogniser extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
      return window.innerWidth < 900 ? <BaseMobile/> : <BaseDesktop/>;
    }
}