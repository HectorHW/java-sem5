import { Component } from "react";

export class ShapeSelector extends Component {
    render() {

        let options = this.props.options.map((k) => {
            return (<option value={k.idx} key={k.name}>{k.name}</option>);
        });

        return (<div>
            <select name="shapeSelect" id="shapeSelector">
                {options}
            </select>
        </div>)
    }
}