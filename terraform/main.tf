provider "aws" {
  region = "us-west-2"
}

resource "aws_s3_bucket" "ecom_bucket" {
  bucket = "inductive-ecom-platform"
  acl    = "private"
}
