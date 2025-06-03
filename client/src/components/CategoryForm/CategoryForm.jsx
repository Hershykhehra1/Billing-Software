
const CategoryForm = () => {
  return (
    <div className="mx-2 mt-2">
      <div className="row">
        <div className="card col-md-8 form-container">
          <div className="card-body">
            <form>
              <div className="mb-3">
                <label htmlFor="image" className="form-label">
                  <img src="https://placehold.co/48x48" alt="" width={48} />
                </label>
                <input type="file" name="image" id="image" className="form-control" hidden />
              </div>
              {/* name */}
              <div className="mb-3">
                <label htmlFor="name" className="form-label">Name</label>
                <input type="text" name="name" id="name" className="form-control" placeholder="Category Name"/>
              </div>

              {/* description */}
              <div className="mb-3">
                <label htmlFor="description" className="form-label">Description</label>
                <textarea rows="5" name="description" id="description" className="form-control" placeholder="Write description here..." ></textarea>
              </div>

              {/* bg color */}
              <div className="mb-3">
                <label htmlFor="bgcolor" className="form-label">Background Color</label>
                <br />
                <input type="color" name="bgColor" id="bgcolor" className="form-control" placeholder="#ffffff" />
              </div>

              <button type="submit" className="btn btn-warning w-100">Save</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  )
}

export default CategoryForm;