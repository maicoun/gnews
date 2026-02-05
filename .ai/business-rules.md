# Business Rules

## Domain
- **Context**: Simulation of the GNews API (Google News clone/mock).
- **Scope**: Providing fake news headlines and search capabilities via API.
- **Goal**: Mimic the GNews API interface for development/testing purposes without real data.

## API Specification
- **Endpoints**:
  - `GET /api/v4/top-headlines`: Retrieve breaking news simulations.
  - `GET /api/v4/search`: Search through the fake news dataset.
- **Parameters**: Must strictly follow GNews official parameter specs (e.g., `q`, `lang`, `country`, `max`, `in`, etc. as applicable to the mock).

## Security & Limits
- **API Key**:
  - Required for all requests `apikey`.
  - Validated against a configured key in `application.yml`.
- **Rate Limiting**:
  - Implementation: In-memory counter/token bucket.
  - Scope: Per API Key.
  - Limit: Daily quota reset.

## Content & Source Rules
- **News Content**:
  - ALWAYS fake/simulated.
  - NEVER copy real news text.
- **Sources**:
  - Names MUST be ficticious (e.g., "The Daily Mock", "Global Times Sim").
  - URLs MUST use reserved/example domains (e.g., `https://news.example.com/id/123`).
- **Imagery**:
  - Images are **MANDATORY** in response objects.
  - **Allowed Sources**: Exclusively royalty-free stock photo URLs:
    - Unsplash (`source.unsplash.com` deprecated, use valid direct links or placeholders)
    - Pexels
    - Pixabay
  - **Forbidden**: Never use images from real news portals (CNN, BBC, NYT, etc.).
