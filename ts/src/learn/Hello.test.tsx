import { render, screen } from '@testing-library/react';
import Hello from "./Hello";

test('Hello World test', () => {
    render(<Hello />);
    const heading = screen.getByText('Hello, World!');
    expect(heading).toBeInTheDocument();
});