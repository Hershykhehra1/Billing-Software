import CategoryForm from '../../components/CategoryForm/CategoryForm';
import CategoryList from '../../components/CategoryList/CategoryList';
import './ManageCategory.css';

const ManageCategory = () => {
  return (
    <div className="category-container test-light">
      <div className="left-column text-light">
        <CategoryForm />
      </div>

      <div className="right-column text-light">
        <CategoryList />
      </div>
    </div>
  )
}

export default ManageCategory;