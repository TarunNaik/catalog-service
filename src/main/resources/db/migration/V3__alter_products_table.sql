-- 1. Add column with a temporary default
ALTER TABLE products
ADD COLUMN vendor_id UUID;

-- 2. Backfill existing rows with a placeholder/default vendor
UPDATE products
SET vendor_id = '6f376ce4-5438-4057-b1d7-4c75351fae3c'  -- Replace with an actual default vendor ID
WHERE vendor_id IS NULL;

-- 3. Enforce NOT NULL constraint
ALTER TABLE products
ALTER COLUMN vendor_id SET NOT NULL;
