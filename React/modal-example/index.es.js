import React from "react";
import ReactDOM from "react-dom";

class Demo extends React.Component {
  constructor(props) {
    super(props);
    this.openModal = this.openModal.bind(this);
  }

  openModal() {
    Liferay.Util.openWindow({
      dialog: {
        bodyContent: "Modal body",
        centered: true,
        headerContent: "<h3>Modal header</h3>",
        modal: true,
        width: 400
      }
    });
  }

  render() {
    return (
      <div>
        <button
          id="openDiv"
          value="Open Popup Using Modal Dialog"
          onClick={this.openModal}
        >
          Click here!
        </button>
      </div>
    );
  }
}

export default function(elementId) {
  ReactDOM.render(<Demo />, document.getElementById(elementId));
}
