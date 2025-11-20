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

## API Examples
- GET /items
- POST /items
- GET /variants
- POST /variants
- GET /stock
- POST /stock
