/** @type {import('next').NextConfig} */
const nextConfig = {
  reactStrictMode: true,
  swcMinify: true,
  redirects: () => [
    {
      source: '/',
      destination: '/todo',
      permanent: true,
    },
  ],
};

module.exports = nextConfig;
