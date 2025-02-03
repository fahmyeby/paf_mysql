-- Insert sample data into 'departments' table
INSERT INTO departments(name) VALUES ('HR'), ('Engineering'), ('Sales');

-- Insert sample data into 'employees' table
INSERT INTO employees (name, salary, dept_id, date_of_birth) VALUES
    ('John Doe', 50000.00, 1, '1999-01-15'),
    ('Jane Smith', 60000.00, 2, '1992-06-25'),
    ('Ali Khan', 55000.00, 3, '1988-12-10'),
    ('Maria Garcia', 62000.00, 1, '1995-04-30'),
    ('Wei Zhang', 58000.00, 2, '1990-09-12'),
    ('Aisha Rahman', 53000.00, 3, '1997-07-05'),
    ('David Lee', 70000.00, 1, '1985-02-18'),
    ('Elena Petrova', 48000.00, 2, '1998-11-23'),
    ('Carlos Mendes', 52000.00, 3, '1994-08-14'),
    ('Sara Ahmed', 61000.00, 1, '1993-05-27');

