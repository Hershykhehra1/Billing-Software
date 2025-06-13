import { Routes, Route, useLocation } from "react-router-dom"; 
import Menubar from "./components/Menubar/Menubar";
import Dashboard from "./pages/Dashboard/Dashboard";
import Explore from "./pages/Explore/Explore";
import ManageCategory from "./pages/ManageCategory/ManageCategory";
import ManageUsers from "./pages/ManageUsers/ManageUsers";
import ManageItems from "./pages/ManageItems/ManageItems";
import { Toaster } from "react-hot-toast";
import Login from "./pages/Login/Login";

const App = () => {
  const location = useLocation();
  return (
    <div>
      {location.pathname !== "/login" && <Menubar />}
      <Toaster />
      <Routes>
          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/category" element={<ManageCategory />} />
          <Route path="/users" element={<ManageUsers />} />
          <Route path="/items" element={<ManageItems />} />
          <Route path="/explore" element={<Explore />} />
          <Route path="/login" element={<Login />} />
          <Route path="/" element={<Dashboard />} />
      </Routes>
    </div>
  );
}
export default App;