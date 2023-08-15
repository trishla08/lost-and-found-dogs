import reactRefresh from "@vitejs/plugin-react-refresh";
import { defineConfig } from "vite";

export default defineConfig({
  plugins: [reactRefresh()],
  build: {
    outDir: "dist", // Change this to your desired output directory
    assetsDir: "", // Change this if you have an assets directory
    rollupOptions: {
      input: {
        main: "index.html", // Entry point for your app
      },
    },
  },
});
