# Shop Warehouse API

## How to Run
1. Clone repo
2. Run:
   mvn spring-boot:run
3. Swagger UI: http://localhost:8080/swagger-ui/index.html

## Design Decisions
- Entity utama untuk Fitur 1: Item
- Validasi: mencegah membuat item dengan nama duplikat

## note
- Variant dan Stock akan diimplementasikan di fitur berikutnya


## Assumptions
- Semua harga dalam USD
- Database H2 in-memory untuk simplicity

### API Examples
## ITEMS
- GET /items
- POST /items
- GET /api/items/{id}
- PUT /api/items/{id}
- DELETE /api/items/{id}

## format json
# POST ITEMS
{
  "name": "",
  "description": ""
}
# PUT ITEMS
- sesuai idnya
{
  "name": "",
  "description": ""
}
# GET ID ITEMS
- masukan Idnya saja

# GET ALL
- tinggal execute

## VARIANTS
- POST /api/variants
- GET /api/variants
- POST /api/items/{id}
- PUT /api/items/{id}
- DELETE /api/items/{id}

## format json
# POST VARIANTS
{
  "name": "",
  "price": 
}
# PUT
- sesuaikan idnya
{
  "name": "Size L - New",
  "price": 160000
}

# DELETE
- masukan idnya

# GET ALL
- tinggal execute


## Next Fitur API
- GET /api/stock (akan diimplementasikan di fitur berikutnya)
- POST /api/stock (akan diimplementasikan di fitur berikutnya)