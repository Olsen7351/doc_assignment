import { render, screen } from '@testing-library/react';
import App from './App';

test('renders Todo View header', () => {
  render(<App />);
  const linkElement = screen.getByText(/Todo View/i);
  expect(linkElement).toBeInTheDocument();
});

test('renders logo', () => {
  render(<App />);
  const logoElement = screen.getByAltText('logo');
  expect(logoElement).toBeInTheDocument();
});

test('renders TodoView component', () => {
  render(<App />);
  const todoViewElement = screen.getByTestId('todo-view');
  expect(todoViewElement).toBeInTheDocument();
});

test('renders App component without crashing', () => {
  render(<App />);
  const appElement = screen.getByTestId('app');
  expect(appElement).toBeInTheDocument();
});

// Dummy tests
test('dummy test 1', () => {
  expect(true).toBe(true);
});

test('dummy test 2', () => {
  expect(1 + 1).toBe(2);
});

test('dummy test 3', () => {
  const arr = [1, 2, 3];
  expect(arr).toHaveLength(3);
});

test('dummy test 4', () => {
  const obj = { name: 'John', age: 25 };
  expect(obj).toHaveProperty('name');
});

test('dummy test 5', () => {
  const str = 'Hello, world!';
  expect(str).toMatch(/Hello/);
});

test('dummy test 6', () => {
  const num = 10;
  expect(num).toBeGreaterThan(5);
});

test('dummy test 7', () => {
  const arr = [1, 2, 3];
  expect(arr).toContain(2);
});

test('dummy test 8', () => {
  const obj = { name: 'John', age: 25 };
  expect(obj).toEqual({ name: 'John', age: 25 });
});

test('dummy test 9', () => {
  const str = 'Hello, world!';
  expect(str).not.toMatch(/Goodbye/);
});

test('dummy test 10', () => {
  const num = 10;
  expect(num).toBeLessThanOrEqual(20);
});
