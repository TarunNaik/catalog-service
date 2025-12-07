-- Create Category table
CREATE TABLE categories (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    description TEXT,
    status VARCHAR(50) NOT NULL DEFAULT 'ACTIVE',
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Optional: Seed master data
INSERT INTO categories (id, name, description, status) VALUES
    (gen_random_uuid(), 'Electronics', 'Electronic gadgets and devices', 'ACTIVE'),
    (gen_random_uuid(), 'Books', 'Printed and digital books', 'ACTIVE'),
    (gen_random_uuid(), 'Clothing', 'Men and women apparel', 'ACTIVE'),
    (gen_random_uuid(), 'Home & Kitchen', 'Furniture, appliances, and kitchenware', 'ACTIVE'),
    (gen_random_uuid(), 'Sports', 'Sports gear and fitness equipment', 'ACTIVE');
