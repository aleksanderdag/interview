import { defineConfig } from 'vitest/config'
import react from '@vitejs/plugin-react-swc'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  test: {
    globals: true, // makes test(), expect(), describe()
    environment: 'jsdom', // for React DOM
    setupFiles: ['./src/setupTests.ts'], // path to setup file
  },
})
