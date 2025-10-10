import "./App.css";
import AddInquiry from "./components/AddInquiry";
import Inquiries from "./components/Inquiries";
import Navbar from "./components/Navbar";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

function App() {
  return (
    <div>
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route path="/" element={<Inquiries />} />
          <Route path="/inquiries" element={<Inquiries />} />
          <Route path="/add-inquiry" element={<AddInquiry />} />
          <Route path="/update-inquiry/:id" element={<AddInquiry />} />
        </Routes>

        <ToastContainer />
      </BrowserRouter>
    </div>
  );
}

export default App;
