# Shop Warehouse API

## How to Run
1. Clone repo
2. Run:
   mvn spring-boot:run
3. Swagger UI: http://localhost:8080/swagger-ui/index.html

## Design Decisions
- Entities: Item, Variant, Stock
- Variant linked to Item (one-to-many)
- Stock linked to Variant
- Validation to prevent selling out-of-stock items

## Assumptions
- All prices in USD
- In-memory DB (H2) for simplicity

## API Examples
- GET /items
- POST /items
- GET /variants
- POST /variants
- GET /stock
- POST /stock
