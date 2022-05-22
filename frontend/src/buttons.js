import React, { Component } from "react";
import "./index.css";

import get_host from "./shared";


export class SaveButton extends Component {
    render() {
        return (
            <button
                onClick={() => {
                    fetch(`${get_host()}/api/state`).then(content => content.json()).then(data => {
                        let a = document.createElement("a");
                        a.href = window.URL.createObjectURL(new Blob([JSON.stringify(data)]), { type: "text/plain" });
                        a.download = "shapes.json";
                        a.click();
                    })
                }}
                className="control-button"> Save </button>
        );
    }
}

export class LoadButton extends Component {
    constructor(props) {
        super(props);
        let reader = new FileReader();

        function upload_file(e) {
            let content = reader.result;

            fetch(`${get_host()}/api/state`,
                {
                    method: "POST",
                    body: content,
                    headers: {
                        'Content-Type': 'application/json'
                    },
                }).catch(e => console.error("failed upload:", e))
        }

        reader.onloadend = upload_file;

        this.state = { reader: reader, inputOpenFileRef: React.createRef() };
    }

    showOpenFileDialog = () => {
        this.state.inputOpenFileRef.current.click()
    }

    render() {
        return <div>
            <input
                type="file"
                id="file"
                onChange={
                    (event) => {
                        let file = event.target.files[0];
                        if (!file) {
                            return;
                        }

                        this.state.reader.readAsText(file);
                        event.target.value = null;
                    }
                }
                ref={this.state.inputOpenFileRef}
                style={{ display: 'none' }}
            />
            <button className="control-button"
                onClick={
                    this.showOpenFileDialog
                }>Load</button>
        </div>
    }
}