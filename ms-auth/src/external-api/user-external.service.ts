import { Injectable } from '@nestjs/common';

@Injectable()
export class UserExternalService {

  constructor() {}

  getUserByEnrollmentAndPass(enrollment: string, pass: string) {
    return undefined;
  }
}