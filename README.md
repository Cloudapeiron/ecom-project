# 🛒 Working on cloud service integration

**Technologies:** Java 17+ | Spring Boot | Gradle | AWS | Docker | PostgreSQL | REST API

A modern, cloud-native RESTful API backend for an e-commerce application built with **Spring Boot**, **Gradle**, and **AWS**. Designed for enterprise-scale deployment with comprehensive AWS integration, providing a robust, scalable foundation for web and mobile front-ends.

---

## ☁️ AWS Cloud Architecture

### **Core AWS Services Integration**

Our e-com backend leverages a comprehensive AWS ecosystem designed for enterprise-scale performance, security, and reliability.

**Frontend Layer:**
- **AWS API Gateway** handles all incoming requests with built-in rate limiting, request validation, and authentication
- **AWS Application Load Balancer** distributes traffic across multiple container instances for high availability

**Application Layer:**
- **AWS ECS (Elastic Container Service)** runs our Spring Boot application in Docker containers with auto-scaling capabilities
- **AWS Fargate** provides serverless container hosting, eliminating infrastructure management overhead
- **AWS EKS (Elastic Kubernetes Service)** planned for advanced container orchestration in production

**Authentication & Security:**
- **AWS Cognito** manages user authentication, registration, and JWT token generation
- **AWS IAM** controls service-to-service permissions and access policies
- **AWS Secrets Manager** securely stores database credentials and API keys

**Data Layer:**
- **AWS RDS PostgreSQL** serves as our primary database with Multi-AZ deployment for high availability
- **AWS ElastiCache (Redis)** provides high-speed caching for sessions and frequently accessed data
- **AWS S3** stores product images, user uploads, and static content with lifecycle management

**Processing & Messaging:**
- **AWS Lambda** handles background processing including order fulfillment, image processing, and email notifications
- **AWS SQS** manages asynchronous message queues for decoupled service communication
- **AWS SNS** sends push notifications and system alerts

**Monitoring & Operations:**
- **AWS CloudWatch** provides comprehensive logging, metrics collection, and alerting
- **AWS X-Ray** enables distributed tracing for performance optimization
- **AWS CloudTrail** maintains audit logs for security and compliance

### **Environment Configuration**

| Environment | Database | Container Platform | Domain |
|-------------|----------|-------------------|---------|
| **Development** | H2 In-Memory | Local Docker | `localhost:8080` |
| **Staging** | AWS RDS (t3.micro) | AWS ECS Fargate | `api-staging.yourdomain.com` |
| **Production** | AWS RDS (Multi-AZ) | AWS EKS | `api.yourdomain.com` |

### **AWS Cost Optimization Strategy**
- **RDS**: Start with `db.t3.micro` for development, scale to `db.r6g.large` for production
- **ECS**: Use Fargate Spot instances for cost-effective container hosting
- **S3**: Implement lifecycle policies for automated archival to reduce storage costs
- **CloudWatch**: Set up log retention policies to manage storage expenses
- **ElastiCache**: Use `cache.t4g.micro` for development environments

---

## 🚀 Quick Start

```bash
# Clone the repository
git clone https://github.com/yourusername/ecom-project.git
cd ecom-project

# Build the project
./gradlew build

# Run the application
./gradlew bootRun
```

The API will be available at `http://localhost:8080`

---

## 📋 Current Status

### ✅ Completed Features
- [x] **Spring Boot Setup** - Backend running on port `8080`
- [x] **Gradle Configuration** - Build system configured and functional
- [x] **Product API** - `/products` endpoint with basic CRUD operations
- [x] **Product Model** - Entity with id, name, and price fields
- [x] **Home Controller** - Root `/` endpoint for health checks
- [x] **Git Integration** - Repository initialized and synced with GitHub
- [x] **REST Endpoints** - Basic API structure established

### 🔄 In Progress
- [ ] Unit and integration testing framework
- [ ] Spring Data JPA integration
- [ ] Database persistence layer
- [ ] AWS RDS PostgreSQL setup
- [ ] AWS IAM role configuration

### 📅 Upcoming Features
- [ ] **Authentication System** - User registration and login with AWS Cognito
- [ ] **Database Integration** - AWS RDS PostgreSQL with connection pooling
- [ ] **Shopping Cart** - Session-based cart with AWS ElastiCache
- [ ] **Order Management** - Complete order lifecycle with AWS SQS
- [ ] **Container Deployment** - AWS ECS/EKS with Docker
- [ ] **API Gateway** - AWS API Gateway for routing and rate limiting
- [ ] **File Storage** - AWS S3 for product images and documents
- [ ] **Serverless Functions** - AWS Lambda for background processing
- [ ] **Monitoring** - AWS CloudWatch for logging and metrics
- [ ] **Security** - JWT authentication with AWS IAM integration

---

## 🏗️ Project Structure

```
ecom-project/
├── 📁 src/
│   ├── 📁 main/
│   │   ├── 📁 java/
│   │   │   └── 📁 com/
│   │   │       └── 📁 example/
│   │   │           └── 📁 ecom/
│   │   │               ├── 📄 EcomApplication.java          # Main Spring Boot application
│   │   │               ├── 📁 controller/
│   │   │               │   ├── 📄 HomeController.java       # Root endpoint controller
│   │   │               │   └── 📄 ProductController.java    # Product API endpoints
│   │   │               ├── 📁 model/
│   │   │               │   └── 📄 Product.java              # Product entity model
│   │   │               ├── 📁 service/                      # Business logic layer (planned)
│   │   │               ├── 📁 repository/                   # Data access layer (planned)
│   │   │               ├── 📁 config/                       # Configuration classes (planned)
│   │   │               │   ├── 📄 AwsConfig.java            # AWS SDK configuration
│   │   │               │   ├── 📄 DatabaseConfig.java       # RDS connection config
│   │   │               │   └── 📄 SecurityConfig.java       # Security & JWT config
│   │   │               └── 📁 lambda/                       # AWS Lambda functions
│   │   │                   ├── 📄 OrderProcessor.java      # Order processing Lambda
│   │   │                   └── 📄 ImageProcessor.java      # S3 image processing
│   │   └── 📁 resources/
│   │       ├── 📄 application.properties                    # Local configuration
│   │       ├── 📄 application-dev.properties                # Development (H2)
│   │       ├── 📄 application-prod.properties               # Production (AWS RDS)
│   │       └── 📁 aws/                                      # AWS configuration files
│   │           ├── 📄 cloudformation-template.yaml          # Infrastructure as Code
│   │           ├── 📄 ecs-task-definition.json              # ECS container config
│   │           └── 📄 api-gateway-swagger.yaml              # API Gateway definition
│   └── 📁 test/
│       └── 📁 java/
│           └── 📁 com/
│               └── 📁 example/
│                   └── 📁 ecom/
│                       ├── 📄 EcomApplicationTests.java     # Integration tests
│                       └── 📁 aws/                          # AWS integration tests
│                           ├── 📄 S3ServiceTest.java        # S3 integration tests
│                           └── 📄 RdsConnectionTest.java    # Database connection tests
├── 📁 gradle/
│   └── 📁 wrapper/
│       ├── 📄 gradle-wrapper.jar
│       └── 📄 gradle-wrapper.properties
├── 📁 docker/
│   ├── 📄 Dockerfile                                        # Container definition
│   ├── 📄 docker-compose.yml                               # Local development stack
│   └── 📄 docker-compose.aws.yml                           # AWS ECS configuration
├── 📁 terraform/                                            # Infrastructure as Code
│   ├── 📄 main.tf                                          # Main Terraform config
│   ├── 📄 variables.tf                                     # Variable definitions
│   ├── 📄 outputs.tf                                       # Output definitions
│   └── 📁 modules/
│       ├── 📁 rds/                                         # RDS module
│       ├── 📁 ecs/                                         # ECS module
│       └── 📁 s3/                                          # S3 module
├── 📁 scripts/
│   ├── 📄 deploy-to-aws.sh                                 # AWS deployment script
│   ├── 📄 setup-local-aws.sh                               # Local AWS CLI setup
│   └── 📄 run-integration-tests.sh                         # Test automation
├── 📄 build.gradle                                          # Gradle build configuration
├── 📄 settings.gradle                                       # Gradle settings
├── 📄 gradlew                                              # Gradle wrapper (Unix)
├── 📄 gradlew.bat                                          # Gradle wrapper (Windows)
├── 📄 buildspec.yml                                        # AWS CodeBuild specification
├── 📄 .gitignore                                           # Git ignore rules
└── 📄 README.md                                            # Project documentation
```

---

## 🛠️ Technology Stack

| Component | Technology | Version | Purpose |
|-----------|------------|---------|---------|
| **Backend Framework** | Spring Boot | 3.x | RESTful API development |
| **Build Tool** | Gradle | 8.x | Dependency management & builds |
| **Language** | Java | 17+ | Core programming language |
| **Database** | AWS RDS (PostgreSQL) | 15+ | Managed database service |
| **Caching** | AWS ElastiCache (Redis) | 7.x | Session & data caching |
| **Authentication** | AWS Cognito | - | User authentication & authorization |
| **File Storage** | AWS S3 | - | Product images & document storage |
| **Message Queue** | AWS SQS | - | Asynchronous message processing |
| **Serverless** | AWS Lambda | - | Background processing functions |
| **Container Orchestration** | AWS ECS/EKS | - | Container deployment & scaling |
| **API Management** | AWS API Gateway | - | API routing, throttling & security |
| **Monitoring** | AWS CloudWatch | - | Logging, metrics & alerting |
| **Infrastructure** | Terraform | 1.5+ | Infrastructure as Code |
| **Testing** | JUnit 5 + TestContainers | 5.x | Unit & integration testing |
| **Containerization** | Docker | Latest | Application packaging |
| **CI/CD** | AWS CodePipeline/CodeBuild | - | Automated deployment pipeline |
| **Version Control** | Git + GitHub | - | Source code management |

---

## 🎯 API Endpoints

### Currently Available

| Method | Endpoint | Description | Status |
|--------|----------|-------------|--------|
| `GET` | `/` | Health check / Welcome message | ✅ Active |
| `GET` | `/products` | Get all products | ✅ Active |

### Planned Endpoints

| Method | Endpoint | Description | AWS Integration | Status |
|--------|----------|-------------|-----------------|--------|
| `POST` | `/products` | Create new product | S3 image upload | 🔄 Planned |
| `PUT` | `/products/{id}` | Update product | S3 image management | 🔄 Planned |
| `DELETE` | `/products/{id}` | Delete product | S3 cleanup | 🔄 Planned |
| `POST` | `/auth/register` | User registration | AWS Cognito | 🔄 Planned |
| `POST` | `/auth/login` | User authentication | AWS Cognito + JWT | 🔄 Planned |
| `GET` | `/cart` | Get user's cart | ElastiCache session | 🔄 Planned |
| `POST` | `/cart/items` | Add item to cart | ElastiCache update | 🔄 Planned |
| `POST` | `/orders` | Create new order | SQS message + Lambda | 🔄 Planned |
| `GET` | `/orders/{id}/status` | Track order status | Lambda processing | 🔄 Planned |
| `POST` | `/upload/image` | Upload product images | S3 direct upload | 🔄 Planned |
| `GET` | `/health` | Health check endpoint | CloudWatch integration | 🔄 Planned |
| `GET` | `/metrics` | Application metrics | CloudWatch metrics | 🔄 Planned |

---

## 🧪 Development Workflow

### Building the Project
```bash
# Clean and build
./gradlew clean build

# Run tests (including AWS integration tests)
./gradlew test

# Generate test reports
./gradlew test jacocoTestReport

# Build Docker image
docker build -t ecom-api:latest .
```

### Running the Application

#### Local Development
```bash
# Run with H2 database (local)
./gradlew bootRun --args='--spring.profiles.active=dev'

# Run with Docker Compose (includes LocalStack for AWS simulation)
docker-compose up -d

# Run integration tests against local AWS services
./scripts/run-integration-tests.sh
```

#### AWS Deployment
```bash
# Configure AWS CLI
aws configure

# Deploy infrastructure with Terraform
cd terraform
terraform init
terraform plan
terraform apply

# Deploy application to ECS
./scripts/deploy-to-aws.sh

# Monitor deployment
aws ecs describe-services --cluster ecom-cluster --services ecom-api-service
```

### AWS Local Development Setup
```bash
# Install LocalStack for local AWS simulation
pip install localstack

# Start LocalStack services
localstack start

# Setup local AWS services
./scripts/setup-local-aws.sh

# Verify local AWS services
aws --endpoint-url=http://localhost:4566 s3 ls
```

---

## 🎯 Architecture Goals

### **Modularity**
- Clean separation of concerns (Controller → Service → Repository)
- Domain-driven design principles
- AWS service abstraction layers
- Microservice-ready architecture with ECS/EKS

### **Scalability**
- Stateless REST API design with AWS Application Load Balancer
- Database optimization with AWS RDS read replicas
- Horizontal scaling with AWS ECS Auto Scaling
- Caching strategy with AWS ElastiCache
- CDN integration with AWS CloudFront

### **Reliability & Availability**
- Multi-AZ database deployment with AWS RDS
- Auto-failover and backup strategies
- Circuit breaker patterns for external service calls
- Dead letter queues for failed message processing
- Health checks and auto-recovery with ECS

### **Security**
- JWT-based authentication with AWS Cognito
- IAM roles and policies for service access
- API security with AWS API Gateway
- Data encryption at rest and in transit
- VPC security groups and NACLs
- Secrets management with AWS Secrets Manager

### **Observability**
- Comprehensive logging with AWS CloudWatch
- Application metrics and custom dashboards
- Distributed tracing with AWS X-Ray
- Performance monitoring and alerting
- Cost monitoring and optimization

### **Testability**
- Unit test coverage with JUnit 5
- Integration testing with TestContainers and LocalStack
- API testing with MockMvc and AWS SDK mocks
- Load testing with AWS Load Testing solution
- Chaos engineering with AWS Fault Injection Simulator

---

## 🔮 Future Roadmap

### Phase 1: AWS Foundation (Current)
- [x] Basic REST API structure
- [ ] AWS RDS PostgreSQL integration
- [ ] AWS S3 configuration for file storage
- [ ] AWS IAM roles and policies setup
- [ ] Basic ECS deployment with Fargate
- [ ] Comprehensive testing with LocalStack

### Phase 2: Core AWS Services
- [ ] AWS Cognito user authentication
- [ ] AWS ElastiCache for session management
- [ ] AWS SQS for asynchronous processing
- [ ] AWS Lambda functions for background tasks
- [ ] AWS API Gateway integration
- [ ] CloudWatch logging and basic monitoring

### Phase 3: Advanced AWS Features
- [ ] AWS EKS migration for container orchestration
- [ ] AWS CloudFront CDN for global content delivery
- [ ] AWS Secrets Manager for configuration
- [ ] AWS X-Ray for distributed tracing
- [ ] Auto Scaling Groups and Application Load Balancer
- [ ] Multi-region deployment strategy

### Phase 4: Enterprise AWS Solutions
- [ ] AWS EventBridge for event-driven architecture
- [ ] AWS Step Functions for complex workflows
- [ ] AWS AppSync for GraphQL API (optional)
- [ ] AWS QuickSight for analytics dashboard
- [ ] AWS Pinpoint for customer engagement
- [ ] Cost optimization with Reserved Instances and Spot

### Phase 5: DevOps & Automation
- [ ] AWS CodePipeline for CI/CD
- [ ] AWS CodeBuild for automated builds
- [ ] Terraform modules for reusable infrastructure
- [ ] AWS Config for compliance monitoring
- [ ] AWS CloudFormation for infrastructure templates
- [ ] Blue-Green deployments with ECS

### Phase 6: Advanced Monitoring & Security
- [ ] AWS GuardDuty for threat detection
- [ ] AWS CloudTrail for audit logging
- [ ] AWS WAF for application firewall
- [ ] AWS Shield for DDoS protection
- [ ] Comprehensive alerting with SNS
- [ ] Performance optimization with AWS Performance Insights

---

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

---

## 📞 Contact & Support

- **Project Repository**: [GitHub](https://github.com/yourusername/ecom-project)
- **Issues**: [GitHub Issues](https://github.com/yourusername/ecom-project/issues)
- **Discussions**: [GitHub Discussions](https://github.com/yourusername/ecom-project/discussions)

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

<div align="center">
  <strong>Built with ❤️ using Spring Boot</strong>
</div>
