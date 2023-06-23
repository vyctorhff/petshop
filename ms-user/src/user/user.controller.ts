import { Controller, Post, Get, Body, HttpCode, NotImplementedException } from '@nestjs/common';
import { UserService } from './user.service';
import { UserEnrollmentRequestDTO } from './dtos/user-enrollment.request.dto';
import { User } from './entities/user.entity';
import { UserCreateRequestDTO } from './dtos/create.request.dto';

@Controller('user')
export class UserController {

  constructor(private readonly service: UserService) {}

  @Post()
  @HttpCode(204)
  async create(@Body() dto: UserCreateRequestDTO): Promise<void> {
    await this.service.create(dto);
  }

  @Get()
  async getUserByEnrollment(@Body() dto: UserEnrollmentRequestDTO): Promise<User> {
    return this.service.getUserByEnrollment(dto);
  }
}
