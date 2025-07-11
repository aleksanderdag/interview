import { render, screen, fireEvent } from "@testing-library/react";
import App from "./App";

test("Give the image a proper alt tag using the author's name", () => {
    const { container } = render(<App />);
    const img = container.querySelector("img");
    expect(img).toHaveAttribute("alt", expect.stringContaining("Lynn Fisher"));
});

test("Make sure the badge displays the profile image correctly", () => {
    const { container } = render(<App />);
    const img = container.querySelector("img");
    expect(img).toHaveAttribute("src", expect.stringContaining("https://avatars.githubusercontent.com/u/871315"));
});

test("Display the author's name in the badge's heading", () => {
    const { container } = render(<App />);
    const heading = container.querySelector("h4");
    expect(heading).toHaveTextContent("Lynn Fisher");
});

test("Display the author's handle below the heading", () => {
    const { container } = render(<App />);
    const paragraph = container.querySelector("p");
    expect(paragraph).toHaveTextContent("lynnandtonic");
});

test("Apply the correct styles to the outer div", () => {
    const { container } = render(<App />);
    const outerDiv = container.querySelector("div[style]");
    expect(outerDiv).toHaveStyle("text-align: center;");
});

test("Pass the click handler to the button so that it opens an alert when clicked", () => {
    const originalAlert = window.alert;
    const alertMock = vi.fn();
    window.alert = alertMock;
    render(<App />);
    const button = document.querySelector("button")!;
    fireEvent.click(button);
    expect(alert).toBeCalled();
    window.alert = originalAlert;
});