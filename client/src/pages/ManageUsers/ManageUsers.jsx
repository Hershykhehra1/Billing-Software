import './ManageUsers.css';
import UserForm from '../../components/UserForm/UserForm';
import UsersList from '../../components/UsersList/UsersList';

const ManageUsers = () => {
  return (
    <div className="users-container test-light">
      <div className="left-column text-light">
        <UserForm />
      </div>

      <div className="right-column text-light">
        <UsersList />
      </div>
    </div>
  )
}

export default ManageUsers;