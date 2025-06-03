import './ManageItems.css';
import ItemForm from '../../components/ItemForm/ItemForm';
import ItemList from '../../components/ItemList/ItemList';

const ManageItems = () => {
  return (
    <div className="items-container test-light">
      <div className="left-column text-light">
        <ItemForm />
      </div>

      <div className="right-column text-light">
        <ItemList />
      </div>
    </div>
  )
}

export default ManageItems;