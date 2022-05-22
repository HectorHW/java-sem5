import "./index.css";
import React, { Component } from "react";
import { createRoot } from 'react-dom/client';
import { Stage, Layer, Line, Ellipse, Rect } from 'react-konva';

import TopPanel from "./top";

import DrawApp from "./main_page";

class App extends Component {
  render() {
    return (
      <div>
        <TopPanel />
        <DrawApp />
      </div>
    )
  }
}


const root = createRoot(document.getElementById('root'));

root.render(<App />);
