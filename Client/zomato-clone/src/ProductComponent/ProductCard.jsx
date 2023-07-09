import demo_img from "../Images/product_demo_img.png"
import "./productcard.css"

const ProductCard = (product) => {
    return ( <div className="flex flex-col  card">
         
             <img src={"http://localhost:8080/admin/product/"+product.item.productImage} alt="" width="328px" height="248px" 
                className="max=w-[328px] max-h-[248px] bg-fill"
             />

             <div className="flex justify-between mt-2">
                 <h3 className="max-w-[250px] leading-5 font-bold">{product.item.title}</h3>
                 <h4 className="rating"> Rating : {product.item.rating}</h4>
             </div>

             
             <div className="flex justify-between my-1">
                 <h3 className="opacity-60" id="hotelname">{product.item.description}</h3>
                 <h4 id="price" className="opacity-60">Rs {product.item.price} for 1</h4>
             </div>

             <div className="flex justify-between">
                 <h3 className="opacity-50">Chaoni, Nagpur</h3>
                 <h4 id="distance" className="opacity-50">2.8 km</h4>
             </div>
               
    </div> );
}
 
export default ProductCard;