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

### ✅ Saat berhasil
### Json Items
## Response POST
{
  "id": 1,
  "name": "Laptop",
  "description": "Laptop gaming 2025",
  "variants": null
}
## Response GET All
[
  {
    "id": 1,
    "name": "Laptop",
    "description": "Laptop gaming 2025",
    "variants": []
  }
]
## Response DELETE
connection: keep-alive 
 content-length: 0 
 date: Thu,20 Nov 2025 16:24:16 GMT 
 keep-alive: timeout=60 

## Response PUT
{
  "id": 1,
  "name": "Laptop asus",
  "description": "Laptop gaming asus 2025",
  "variants": []
}
## Response GET ID
{
  "id": 1,
  "name": "Laptop asus",
  "description": "Laptop gaming asus 2025",
  "variants": []
}

### Json Variant
## Response POST ID
{
  "id": 1,
  "name": "Laptop Hitam 16GB",
  "price": 1500,
  "stock": 10,
  "item": {
    "id": 1,
    "name": "Laptop asus",
    "description": "Laptop gaming asus 2025"
  }
}
## Response GET ALL
[
  {
    "id": 1,
    "name": "Laptop Hitam 16GB",
    "price": 1500,
    "stock": 10,
    "item": {
      "id": 1,
      "name": "Laptop asus",
      "description": "Laptop gaming asus 2025"
    }
  }
]
## Response PUT
{
  "id": 1,
  "name": "Laptop Hitam 32GB",
  "price": 1800,
  "stock": 10,
  "item": {
    "id": 1,
    "name": "Laptop asus",
    "description": "Laptop gaming asus 2025"
  }
}
## Response add stock
{
  "id": 1,
  "name": "Laptop Hitam 32GB",
  "price": 1800,
  "stock": 20,
  "item": {
    "id": 1,
    "name": "Laptop asus",
    "description": "Laptop gaming asus 2025"
  }
}
## Response reduce stock
{
  "id": 1,
  "name": "Laptop Hitam 32GB",
  "price": 1800,
  "stock": 15,
  "item": {
    "id": 1,
    "name": "Laptop asus",
    "description": "Laptop gaming asus 2025"
  }
}

### ❌ Saat gagal
## ketika nama duplikat
{
  "timestamp": "2025-11-20T16:34:49.861+00:00",
  "status": 500,
  "error": "Internal Server Error",
  "path": "/api/variants/1"
}

### ✅ NOTES
- Reduce stock gagal bila stock tidak cukup
- Add/Reduce stock mengembalikan stock terbaru
- Validasi nama item & variant unik dilakukan di service
- Variant tidak bisa dibuat tanpa Item yang valid