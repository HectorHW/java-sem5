import { Component } from "react";

export class ShapeSelector extends Component {
    render() {

        let options = Object.keys(this.props.options).map((k) => {
            <option value={k.idx}>{k.name}</option>
        });

        return (<div>
            <select name="shapeSelect">
                {options}
            </select>
        </div>)
    }
}