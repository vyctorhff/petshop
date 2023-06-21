import { BadRequestException, Injectable, Logger } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';

import { UserEnrollmentRequestDTO } from './dtos/user-enrollment.request.dto';
import { UserCreateRequestDTO, toUser } from './dtos/create.request.dto';
import { User } from './entities/user.entity';

@Injectable()
export class UserService {
  private readonly logger: Logger = new Logger('UserService');

  constructor(
    @InjectRepository(User)
    private readonly repository: Repository<User>
  ) {}

  async create(dto: UserCreateRequestDTO): Promise<void> {
    const userExists = await this.getUserByEnrollment({ enrollment: dto.enrollment });

    if (!userExists) {
      this.logger.error(`User with already exists: ${dto.enrollment }`);
      throw new BadRequestException('user already exists');
    }

    const user = toUser(dto);
    this.repository.insert(user);

    this.logger.log('User created');
  }

  async getUserByEnrollment(dto: UserEnrollmentRequestDTO): Promise<User> {
    const builder = this.repository.createQueryBuilder('userr');

    builder.where("userr.enrollment = :enrollment", dto);
    return builder.getOne();
  }
}
