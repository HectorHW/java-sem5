import { Component } from "react";
import "./index.css";

import get_host from "./shared";




class TopPanel extends Component {
    render() {
        return (<div className="top-bg">
            <button onClick={() => { window.open("/" + window.location.search, "_self"); }}
                className="top-button"> Home </button>
            <button onClick={() => { window.open("/add" + window.location.search, "_self"); }}
                className="top-button"> Add shape</button>
        </div>)
    }
}

export default TopPanel;