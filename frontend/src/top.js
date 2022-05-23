import { Component } from "react";
import "./index.css";

import get_host from "./shared";



class TopButton extends Component {
    render() {
        return <button onClick={() => {
            window.open(this.props.path + window.location.search, "_self");
        }} className="top-button">{this.props.text}</button>
    }
}


class TopPanel extends Component {
    render() {
        return (<div className="top-bg">
            <TopButton path="/" text={"Home"} />
            <TopButton path="/add" text={"Add shape"} />
            <TopButton path="/delete" text={"Delete"} />
            <TopButton path="/move" text={"Move"} />
            <TopButton path="/area" text={"Area"} />
            <TopButton path="/perimeter" text={"Perimeter"} />
            <TopButton path="/intersection" text={"Intersection"} />
        </div>)
    }
}

export default TopPanel;