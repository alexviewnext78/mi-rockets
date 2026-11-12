# Rocket Feature Specification

## 1. Overview

The rocket management feature enables the AstroBookings system to create, maintain, query, and remove rocket records used for launch assignments. A rocket represents a launch-capable vehicle with business attributes such as name, model, status, payload capacity, and operational state. The feature ensures that only valid rockets are available for booking and that invalid or conflicting records cannot be persisted.

This feature supports the operational needs of launch planning and ensures that booking logic is based on accurate rocket data.

## 2. Business goal

The business goal is to provide a reliable and auditable rocket catalog for launch operations. This allows the system to:

- register new rockets safely
- retrieve rockets for operational and administrative use
- update rocket metadata and capabilities without breaking launch planning
- remove rockets only when they are no longer valid or are not in use
- prevent invalid or duplicate rocket records from affecting business flows

## 3. User or API scenarios

### Scenario 1: Create a rocket
A system administrator creates a new rocket with a unique code or name, model, status, and capacity details. The system validates required fields and stores the rocket if it passes all rules.

### Scenario 2: Retrieve one rocket
A user or service requests a specific rocket by identifier and receives the full rocket record if it exists.

### Scenario 3: Retrieve multiple rockets
A user requests a list of rockets, optionally filtered by status, model, or name. The system returns a paginated result set sorted consistently.

### Scenario 4: Update an existing rocket
An administrator updates a rocket’s attributes. The system validates the new values and persists the changes only when all rules are satisfied.

### Scenario 5: Delete a rocket
An administrator deletes a rocket when it is retired or no longer used. The system blocks deletion if the rocket is still assigned to active or scheduled launch activity, unless the business explicitly allows soft deletion.

### Scenario 6: Error handling
If the request is invalid, the system returns a clear validation error or a not-found response depending on the failure type.

## 4. Functional requirements

### 4.1 Rocket creation
The system must support creation of a rocket with the following requirements:

- Each rocket must have a unique identifier or unique business key.
- Required attributes must include:
  - name
  - model
  - status
  - payload capacity or equivalent operational capability
- A rocket must not be created with missing required data.
- Duplicate rocket identifiers or duplicate names that are considered business-unique must be rejected.
- A created rocket should default to a valid operational state unless the caller explicitly sets a status.

### 4.2 Rocket retrieval
The system must support:

- retrieving a single rocket by identifier
- retrieving a list of rockets
- filtering by metadata such as status, model, or name
- sorting in a deterministic order
- pagination for large result sets

If pagination is supported, the API must include page size and page number or cursor-based navigation. The response must clearly indicate total count and page metadata when applicable.

### 4.3 Rocket update
The system must support updating an existing rocket record.

- Only existing rockets may be updated.
- Validation must run on all changed values.
- Updates must preserve uniqueness constraints.
- If a rocket is changed to an invalid operational state, the update must be rejected.
- Partial updates may be supported if the API contract allows it, but the same validation must still apply.

### 4.4 Rocket deletion
The system must support deletion of a rocket record.

- A rocket can only be deleted if it is not currently assigned to an active or scheduled launch.
- If deletion is blocked due to business rules, the system must return a clear conflict error.
- If the system supports soft deletion, the rocket should be marked inactive instead of physically removed; otherwise, hard deletion is allowed only when no business constraint is violated.

### 4.5 Validation rules
The system must validate the following:

- required fields are not null or empty
- rocket name is valid and within the defined length limit
- model is valid and recognized by the system
- capacity values are positive and within supported domain limits
- status is one of the allowed values for the lifecycle model
- duplicate identifiers or business keys are not accepted
- deletion or update operations cannot violate active launch assignments

## 5. Validation and error conditions

The API/service must produce deterministic error handling for these conditions:

- Bad request: missing required field
- Bad request: invalid field format
- Conflict: duplicate rocket identifier or name
- Not found: rocket does not exist
- Conflict: rocket is in use by an active or scheduled launch and cannot be deleted
- Invalid state transition: status update violates allowed lifecycle rules
- Invalid numeric value: payload or capacity below zero or above supported system limit

Error responses should include:

- error code
- human-readable message
- relevant field names when possible

## 6. Acceptance criteria

1. A rocket can be created only if all required fields are present and valid.
2. The system rejects duplicate rocket identifiers or duplicate business names.
3. A single rocket can be retrieved by identifier.
4. Multiple rockets can be retrieved with filtering and pagination.
5. An existing rocket can be updated with valid data and rejected when invalid.
6. A rocket cannot be deleted if it is assigned to an active or scheduled launch.
7. Invalid input returns clear validation errors with no partial persistence.
8. The behavior is consistent across all API endpoints or service methods.
9. The specification aligns with the Java API and domain model expected for the AstroBookings project.
10. This feature is testable through unit, integration, and API-level tests.

## Summary

This feature defines the minimum viable rocket lifecycle behavior needed for the AstroBookings domain: creation, retrieval, update, deletion, validation, and safe handling of conflicts. It is specific enough to be implemented by engineering and used directly for QA validation.
