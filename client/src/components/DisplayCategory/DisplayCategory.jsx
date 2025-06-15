import './DisplayCategory.css';
import Category from '../Category/Category.jsx';

const DisplayCategory = ({ categories, selectedCategory, setSelectedCategory }) => {
  const handleCategoryClick = (categoryId) => {
    // If the clicked category is already selected, unselect it
    if (selectedCategory === categoryId) {
      setSelectedCategory(null);
    } else {
      // Otherwise, select the new category
      setSelectedCategory(categoryId);
    }
  };

  return (
    <div className="row g-3" style={{ width: '100%', margin: 0 }}>
      {categories.map((category) => (
        <div className="col-md-3 col-sm-6" key={category.categoryId} style={{ padding: '0 10px' }}>
          <Category
            categoryName={category.name}
            imgUrl={category.imgUrl}
            numberOfItems={category.items}
            bgColor={category.bgColor}
            isSelected={selectedCategory === category.categoryId}
            onClick={() => handleCategoryClick(category.categoryId)} />
        </div>
      ))}
    </div>
  )
}

export default DisplayCategory;