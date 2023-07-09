import { Link } from "react-router-dom";
import header_img from "../Images/zomato_head.webp";
import "../HeaderComponent/Header.css"
import search from "../Images/search.png";

const Header = () => {
  return (
    // shorcut for creating const funct is sfc
    <header className="w-[1100px] max-w-[1100px] mx-auto"  >
      <nav >
             <ul className="flex gap-2 py-2 items-center justify-between">

                  
                  <li>
                  <a class="nav-link" href="#">
                  <img src={header_img} alt=""  class="img_header"/>
                  </a>
                  </li>

                  <li className="w-[704px]">
                    {/* search bar  and location */}
                    
                     <div className="flex border rounded-sm stroke-[#E8E8E8]">
                     <img src={search} alt="" />
                     <h6>Search for restaurant, cuisine or a dish</h6>
                     </div>
                    
                  </li>
                  <li className=""> Login</li>
                  <li className="end">Sign Up</li>
             </ul>
      </nav>
    </header>
  );
};

export default Header;
