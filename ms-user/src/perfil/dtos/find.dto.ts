export class FindDTO {
  id: number;

  name: string;

  constructor() {}

  hasId(): boolean {
    return Boolean(this.id);
  }

  hasName(): boolean {
    return Boolean(this.name);
  }
}
