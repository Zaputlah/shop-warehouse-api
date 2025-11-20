# Shop Warehouse API

## 🚀 How to Run
1. Clone repo
2. Run:
   mvn spring-boot:run
3. Swagger UI: http://localhost:8080/swagger-ui/index.html

## 🧱 Design Decisions
- Entity utama: Item
- Satu Item dapat memiliki banyak Variant
- Stock disimpan di Variant, bukan di Item 
- Validasi:
  - Tidak boleh membuat Item dengan nama duplikat
  - Nama Variant harus unik per Item
  - Variant harus selalu terhubung ke Item valid

## 📌 Assumptions
- Harga menggunakan USD
- Database menggunakan H2 In-Memory
- API mengikuti standar RESTful
- Manajemen stock hanya boleh via endpoint khusus add-stock dan reduce-stock

## 📚 API Documentation
### 🟩 ITEMS
### Endpoints
- Method	Endpoint	Description
- GET	/api/items	Get all items
- POST	/api/items	Create item
- GET	/api/items/{id}	Get item by ID
- PUT	/api/items/{id}	Update item
- DELETE	/api/items/{id}	Delete item

### JSON Format
### ➕ POST /api/items
- {
  "name": "Laptop",
  "description": "Laptop gaming 2025"
  }

### ✏️ PUT /api/items/{id}
- {
  "name": "Laptop Updated",
  "description": "Spesifikasi diperbarui"
}

### 🟧 VARIANTS
### Endpoints
- Method	Endpoint	Description
- POST	/api/variants/items/{itemId}	Create variant
- GET	/api/variants	Get all
- PUT	/api/variants/{variantId}	Update variant
- DELETE	/api/variants/{variantId}	Delete variant
- POST	/api/variants/{id}/add-stock	Add stock
- POST	/api/variants/{id}/reduce-stock	Reduce stock

### JSON Format
### ➕ POST /api/variants/items/{itemId}
- {
  "name": "Laptop Hitam 16GB",
  "price": 1500,
  "stock": 10
}
### ✏️ PUT /api/variants/{id}
- {
  "name": "Laptop Hitam 32GB",
  "price": 1800,
  "stock": 15
}

### 🟥 STOCK OPERATIONS
### ➕ Add Stock
- POST /api/variants/{id}/add-stock
- {
  "amount": 5
}
### ➖ Reduce Stock
- POST /api/variants/{id}/reduce-stock
- {
  "amount": 3
}

### ✅ NOTES
- Reduce stock gagal bila stock tidak cukup
- Add/Reduce stock mengembalikan stock terbaru
- Validasi nama item & variant unik dilakukan di service
- Variant tidak bisa dibuat tanpa Item yang valid