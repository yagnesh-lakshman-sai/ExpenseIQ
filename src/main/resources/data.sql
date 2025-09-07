INSERT INTO users (email, password, name) VALUES 
('rahul.kumar@company.com', 'rahul123', 'Rahul Kumar'),
('priya.sharma@company.com', 'priya123', 'Priya Sharma'),
('arjun.mehta@company.com', 'arjun123', 'Arjun Mehta');

-- =============================
-- INSERT CATEGORIES
-- =============================
INSERT INTO categories (name) VALUES 
('Food & Beverages'),
('Transport'),
('Shopping'),
('Bills & Utilities'),
('Health & Fitness'),
('Subscriptions'),
('Travel');

-- =============================
-- INSERT EXPENSES
-- =============================

-- Rahul (Bangalore, spends on Zomato + Netflix)
INSERT INTO expenses (description, amount, date, user_id, category_id) VALUES
('Breakfast at Starbucks', 320.00, '2025-09-01', 1, 1),
('Uber to office', 250.00, '2025-09-01', 1, 2),
('Netflix subscription', 649.00, '2025-09-01', 1, 6),
('Lunch Zomato - Biryani', 400.00, '2025-09-02', 1, 1),
('Electricity bill', 1800.00, '2025-09-03', 1, 4);

-- Priya (fitness + metro + Prime membership)
INSERT INTO expenses (description, amount, date, user_id, category_id) VALUES
('Gym membership', 2000.00, '2025-09-01', 2, 5),
('Metro card recharge', 1000.00, '2025-09-02', 2, 2),
('Swiggy dinner - Thai curry', 550.00, '2025-09-02', 2, 1),
('Amazon Prime subscription', 1499.00, '2025-09-03', 2, 6),
('Myntra - Formal shirt', 1800.00, '2025-09-03', 2, 3);

-- Arjun (weekend trips + Spotify)
INSERT INTO expenses (description, amount, date, user_id, category_id) VALUES
('Ola ride to airport', 800.00, '2025-09-01', 3, 2),
('Flight ticket - Goa', 4500.00, '2025-09-01', 3, 7),
('Dinner at beach shack', 1200.00, '2025-09-01', 3, 1),
('Hotel stay - Goa', 3500.00, '2025-09-02', 3, 7),
('Spotify subscription', 119.00, '2025-09-03', 3, 6);