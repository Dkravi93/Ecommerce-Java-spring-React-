import "./App.css";
import Footer from "./Customer/Components/Footer/Footer";
import HomePage from "./Customer/Components/HomePage/HomePage";
import { Navigation } from "./Customer/Components/Navigation/Navigation";

function App() {
  return (
    <div>
      <Navigation />
      <div>
        <HomePage />
      </div>
      <div>
        <Footer />
      </div>
    </div>
  );
}

export default App;
