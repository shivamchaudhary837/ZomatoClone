import axios from "axios";
import { useState } from "react";
import { toast } from "react-toastify";

const AddCategoryForm = () => {
    
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");

  const callToast=(message)=>{
     console.log("toastttt",title)
     
     toast.success(message, {
      position: "top-center",
      autoClose: 2000,
      hideProgressBar: false,
      closeOnClick: true,
      pauseOnHover: true,
      draggable: true,
      progress: undefined,
    }); 
  }

  const saveCategory=(event)=>{

    const data = { title, description };

    event.preventDefault();

    axios.post("http://localhost:8080/admin/category/add",data).
    then((response)=>{
      callToast("Category Added Successfully")
      setTitle("")
      setDescription("")
      console.log("response", response);
    })
    .catch((error) => {
      console.log("Error", error);
      alert("Error saving product");
    });

    callToast("Category Added Successfully")
    event.preventDefault();

  }
  return (
    <div>
      <div className="mt-2 d-flex aligns-items-center justify-content-center">
        <div
          className="card form-card border-color card-color"
          style={{ width: "35rem",marginTop:"80px" }}
        >
          <div className="card-header custom-bg text-center text-color">
            <h5 className="card-title">Add Category</h5>
          </div>
          <div className="card-body text-color">
            <form  onSubmit={saveCategory}>
              <div className="mb-3">
                <label for="title" className="form-label">
                  <b>Category Title</b>
                </label>
                <input
                  type="text"
                  className="form-control"
                  id="title"
                  placeholder="Enter title"
                  onChange={(e) => {
                    setTitle(e.target.value);
                  }}
                  value={title}
                  required
                />
              </div>
              <div className="mb-3">
                <label for="description" className="form-label">
                  <b>Category Description</b>
                </label>
                <textarea
                  className="form-control"
                  id="description"
                  rows="3"
                  placeholder="Enter description"
                  onChange={(e) => {
                    setDescription(e.target.value);
                  }}
                  value={description}
                  required
                />
              </div>

              <button
                type="submit"
                className="btn bg-color custom-bg-text"
              >
                Add Category
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddCategoryForm;
