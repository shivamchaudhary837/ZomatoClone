
import delivery from "./Images/delivery.png"

import dining from "./Images/dining.png"
import nightlife from "./Images/nightlife.png"
import filter from "./Images/filter.png"
import distance from "./Images/distance.png"
import discount from "./Images/discount.png"
import ProductCard from "./ProductComponent/ProductCard"
import demo_img from "./Images/product_demo_img.png"
import "./homepage.css"
import { useEffect, useState } from "react"
import axios from "axios"

const HomePage = () => {

   const [productList,setProductList]=useState([]);

   const retrieveProducts= async()=>{
       const response=await axios.get("http://localhost:8080/admin/product/all");
       return response.data;
   }
   useEffect(()=>{
      const getAllProduct=async()=>{
         const products=await retrieveProducts();
         console.log("productList",products)
         if(products){
            setProductList(products);
         }
      }

      getAllProduct();
   },[]);
    
    return ( <main className="w-[1100px] mx-auto h-auto my-10">

               

                {/* category section  */}
               <div id="category" className="flex gap-7 my-4 cursor-pointer">
                    
                     {/* for delivery */}
                     <div className="flex px-2 gap-3 items-center justify-center">
                        <img src={delivery} alt=""  />
                        <h3>Delivery</h3>
                     </div>

                     {/* dining out */}
                     <div className="flex px-2 gap-3 items-center justify-center">
                        <img src={dining} alt="" />
                        <h3>Dining Out</h3>
                     </div>

                     {/* NightLife */}
                     <div className="flex px-2 gap-3 items-center justify-center">
                        <img src={nightlife} alt="" />
                        <h3>Nightlife</h3>
                     </div>
               </div>

               {/* filter wala section */}
               <div className="flex py-[16px]  gap-7 my-4 text-[#9C9C9C]" id="filter-sec">
                   
                    <div className="flex cursor-pointer items-center p-2 border-[1px] rounded-md border-[#CFCFCF]
                     filter-items">
                        <img src={filter} alt="" />
                         <h4>Filter</h4>
                    </div>

                    <div className="flex cursor-pointer items-center p-2 border-[1px] rounded-md border-[#CFCFCF]
                     filter-items">
                        Gold
                    </div>

                    <div className="flex cursor-pointer items-center p-2 border-[1px] rounded-md border-[#CFCFCF]
                     filter-items">
                        <img src={distance} alt="" />
                        <h4>Distance</h4>
                    </div>

                    <div className="flex cursor-pointer items-center p-2 border-[1px] rounded-md border-[#CFCFCF]
                     filter-items">
                        <h4>Rating : 4.0+</h4>
                    </div>
               </div>

               {/* discount banner */}
               <div className="cursor-pointer">
                  <img src={discount} alt="" />
               </div>

               <div className="mt-4 mb-4">
                <h3 className="text-3xl  leading-9">Nightlife Restaurants in Mominpura</h3>
               </div>

               <div className="grid grid-cols-3 gap-4">

               {productList.map((product)=>{
                    return <ProductCard item={product} />;
               })
               }

               </div>
               
    </main> );
}
 
export default HomePage;