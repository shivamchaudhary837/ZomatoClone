import './App.css';

import Header from "./HeaderComponent/Header"
import { Routes, Route } from "react-router-dom";
import Footer from "./FooterComponent/Footer"
import AddCategoryForm from './AdminComponent/AddCategoryForm';
import "./index.css";
import AddProductForm from './AdminComponent/AddProductForm';
import HomePage from './HomePage';
import  "./ProductComponent/ProductCard"

function App() {
  return (
    <div >
      
           <Header />

           <Routes >
                 <Route path="admin/addcategory" element={<AddCategoryForm />} />
                 <Route path="admin/addproduct" element={<AddProductForm />} />
                 <Route path="/" element={<HomePage />} />
           </Routes>
           {/* <Footer/> */}

    </div>
  );
}

export default App;
